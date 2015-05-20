
/* First created by JCasGen Thu Dec 08 14:59:57 CET 2011 */
package de.tudarmstadt.langtech.uima.substituter.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Dec 08 14:59:57 CET 2011
 * @generated */
public class Substitution_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Substitution_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Substitution_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Substitution(addr, Substitution_Type.this);
  			   Substitution_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Substitution(addr, Substitution_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Substitution.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.tudarmstadt.langtech.uima.substituter.type.Substitution");
 
  /** @generated */
  final Feature casFeat_senseclass;
  /** @generated */
  final int     casFeatCode_senseclass;
  /** @generated */ 
  public String getSenseclass(int addr) {
        if (featOkTst && casFeat_senseclass == null)
      jcas.throwFeatMissing("senseclass", "de.tudarmstadt.langtech.uima.substituter.type.Substitution");
    return ll_cas.ll_getStringValue(addr, casFeatCode_senseclass);
  }
  /** @generated */    
  public void setSenseclass(int addr, String v) {
        if (featOkTst && casFeat_senseclass == null)
      jcas.throwFeatMissing("senseclass", "de.tudarmstadt.langtech.uima.substituter.type.Substitution");
    ll_cas.ll_setStringValue(addr, casFeatCode_senseclass, v);}
    
  
 
  /** @generated */
  final Feature casFeat_confidence;
  /** @generated */
  final int     casFeatCode_confidence;
  /** @generated */ 
  public float getConfidence(int addr) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "de.tudarmstadt.langtech.uima.substituter.type.Substitution");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_confidence);
  }
  /** @generated */    
  public void setConfidence(int addr, float v) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "de.tudarmstadt.langtech.uima.substituter.type.Substitution");
    ll_cas.ll_setFloatValue(addr, casFeatCode_confidence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_substitutions;
  /** @generated */
  final int     casFeatCode_substitutions;
  /** @generated */ 
  public int getSubstitutions(int addr) {
        if (featOkTst && casFeat_substitutions == null)
      jcas.throwFeatMissing("substitutions", "de.tudarmstadt.langtech.uima.substituter.type.Substitution");
    return ll_cas.ll_getRefValue(addr, casFeatCode_substitutions);
  }
  /** @generated */    
  public void setSubstitutions(int addr, int v) {
        if (featOkTst && casFeat_substitutions == null)
      jcas.throwFeatMissing("substitutions", "de.tudarmstadt.langtech.uima.substituter.type.Substitution");
    ll_cas.ll_setRefValue(addr, casFeatCode_substitutions, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Substitution_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_senseclass = jcas.getRequiredFeatureDE(casType, "senseclass", "uima.cas.String", featOkTst);
    casFeatCode_senseclass  = (null == casFeat_senseclass) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_senseclass).getCode();

 
    casFeat_confidence = jcas.getRequiredFeatureDE(casType, "confidence", "uima.cas.Float", featOkTst);
    casFeatCode_confidence  = (null == casFeat_confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidence).getCode();

 
    casFeat_substitutions = jcas.getRequiredFeatureDE(casType, "substitutions", "uima.cas.StringList", featOkTst);
    casFeatCode_substitutions  = (null == casFeat_substitutions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_substitutions).getCode();

  }
}



    