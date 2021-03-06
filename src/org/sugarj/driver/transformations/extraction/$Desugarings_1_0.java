package org.sugarj.driver.transformations.extraction;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Desugarings_1_0 extends Strategy 
{ 
  public static $Desugarings_1_0 instance = new $Desugarings_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_15)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Desugarings_1_0");
    Fail32:
    { 
      IStrategoTerm a_103 = null;
      IStrategoTerm z_102 = null;
      if(term.getTermType() != IStrategoTerm.APPL || ext_out._consDesugarings_1 != ((IStrategoAppl)term).getConstructor())
        break Fail32;
      z_102 = term.getSubterm(0);
      IStrategoList annos5 = term.getAnnotations();
      a_103 = annos5;
      term = z_15.invoke(context, z_102);
      if(term == null)
        break Fail32;
      term = termFactory.annotateTerm(termFactory.makeAppl(ext_out._consDesugarings_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, a_103));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}