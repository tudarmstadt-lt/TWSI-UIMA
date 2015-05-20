
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.uimafit.component.JCasConsumer_ImplBase;
import org.uimafit.util.JCasUtil;

import de.tudarmstadt.langtech.uima.substituter.type.Substitution;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;



public class SubstitutionValidator extends JCasConsumer_ImplBase {

	/**
	 * our global cas
	 */
	private JCas jcas;

	@Override
	public void process(JCas aCAS) throws AnalysisEngineProcessException {
		Token t;
		this.jcas=aCAS;
		for(Substitution s : JCasUtil.select(jcas, Substitution.class)) {
			System.out.println(s.toString());
			assert(s.getSenseclass().equals("capital@@1"));
			assert(s.getBegin()==37);
		}

	}

}