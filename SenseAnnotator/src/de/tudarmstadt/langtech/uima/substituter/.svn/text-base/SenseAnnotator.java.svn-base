package de.tudarmstadt.langtech.uima.substituter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.CASRuntimeException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.TypeSystem;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyStringList;
import org.apache.uima.jcas.cas.NonEmptyStringList;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.CasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;

import de.tudarmstadt.langtech.substituter.MLSenseSubstituter;
import de.tudarmstadt.langtech.substituter.SenseSubstituter;
import de.tudarmstadt.langtech.uima.substituter.type.Substitution;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.POS;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Lemma;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

/**
 * Creates substitution annotations, based upon the pos and token annotations
 * SenseSubstituter.jar must be in the lib folder
 * See Sense Substituer README.txt for Configuration File parameters
 * @author cwirth
 *
 */
public class SenseAnnotator extends CasAnnotator_ImplBase {

	public static final String PARAM_CONFIG_FILE = "ConfigurationFile";
	@ConfigurationParameter(name = PARAM_CONFIG_FILE, mandatory = true, defaultValue="nofile")
	private final String configFile=null;

	private Type tokenType;
	private Type sentenceType;
	private Feature featLemma;
	private Feature featPos;
	private SenseSubstituter subst;

	@Override
	public void initialize(UimaContext aContext)
	throws ResourceInitializationException
	{
		super.initialize(aContext);
		subst = new MLSenseSubstituter(configFile);	
	}

	@Override
	public void typeSystemInit(TypeSystem aTypeSystem)
	throws AnalysisEngineProcessException
	{
		super.typeSystemInit(aTypeSystem);
		tokenType = aTypeSystem.getType(Token.class.getName());
		sentenceType = aTypeSystem.getType(Sentence.class.getName());
		featLemma = tokenType.getFeatureByBaseName("lemma");
		featPos = tokenType.getFeatureByBaseName("pos");
	}

	@Override
	public void process(CAS arg0) throws AnalysisEngineProcessException {
		try {
			JCas cas = arg0.getJCas();
			AnnotationIndex<Annotation> sentences = cas.getAnnotationIndex(sentenceType);
			AnnotationIndex<Annotation> aiToken = cas.getAnnotationIndex(tokenType);
			for(Annotation b : sentences) {
				FSIterator<Annotation> iter = aiToken.subiterator(b);
				ArrayList<String> words = new ArrayList<String>();
				ArrayList<String> postags = new ArrayList<String>();
				List<Substitution> subs = new ArrayList<Substitution>();
				words.add("%^%");
				postags.add("BOS");
				while(iter.hasNext()) {
					Annotation a = iter.next();
					POS pos = (POS) a.getFeatureValue(featPos);
					Lemma lemma = (Lemma) a.getFeatureValue(featLemma);
					words.add(lemma.getValue());
					postags.add(pos.getPosValue());
					Substitution sub = new Substitution(cas);
					sub.setBegin(a.getBegin());
					sub.setEnd(a.getEnd());
					subs.add(sub);
				}
				words.add("%$%");
				postags.add("EOS");
				for(int i=1;i<words.size()-1;i++) {					
					de.tudarmstadt.langtech.substituter.Substitution s = subst.getSubstitution(i, (String[])words.toArray(new String[]{}), (String[])postags.toArray(new String[]{}));
					if(s!=null) {
						Substitution sub = subs.get(i-1);
						sub.setConfidence(s.getConfidence());
						sub.setSenseclass(s.getSense());
						NonEmptyStringList head = new NonEmptyStringList(cas);
						NonEmptyStringList list = head;
						if(s.getSubstitutions()!=null) {
							Iterator<String[]> iter2 = s.getSubstitutions().iterator();
							while (iter2.hasNext()) {
								String[] entry = iter2.next();
								head.setHead(entry[0]+":"+entry[1]);
								if (iter2.hasNext()) {
									head.setTail(new NonEmptyStringList(cas));
									head = (NonEmptyStringList) head.getTail();
								}
								else {
									head.setTail(new EmptyStringList(cas));
								}
							}
						}
						list.addToIndexes();
						sub.setSubstitutions(list);
						sub.addToIndexes();
					}
				}
			}
		} catch (CASRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CASException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
