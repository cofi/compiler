package org.sugarj.driver.transformations.renameRules;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Ext$Op$Decl$Inj_1_0 extends Strategy 
{ 
  public static $Ext$Op$Decl$Inj_1_0 instance = new $Ext$Op$Decl$Inj_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_16)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ExtOpDeclInj_1_0");
    Fail111:
    { 
      IStrategoTerm w_109 = null;
      IStrategoTerm v_109 = null;
      if(term.getTermType() != IStrategoTerm.APPL || out._consExtOpDeclInj_1 != ((IStrategoAppl)term).getConstructor())
        break Fail111;
      v_109 = term.getSubterm(0);
      IStrategoList annos102 = term.getAnnotations();
      w_109 = annos102;
      term = z_16.invoke(context, v_109);
      if(term == null)
        break Fail111;
      term = termFactory.annotateTerm(termFactory.makeAppl(out._consExtOpDeclInj_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, w_109));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}