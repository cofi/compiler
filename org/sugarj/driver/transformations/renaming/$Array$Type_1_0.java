package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Array$Type_1_0 extends Strategy 
{ 
  public static $Array$Type_1_0 instance = new $Array$Type_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy s_38)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ArrayType_1_0");
    Fail190:
    { 
      IStrategoTerm p_168 = null;
      IStrategoTerm o_168 = null;
      if(term.getTermType() != IStrategoTerm.APPL || out._consArrayType_1 != ((IStrategoAppl)term).getConstructor())
        break Fail190;
      o_168 = term.getSubterm(0);
      IStrategoList annos159 = term.getAnnotations();
      p_168 = annos159;
      term = s_38.invoke(context, o_168);
      if(term == null)
        break Fail190;
      term = termFactory.annotateTerm(termFactory.makeAppl(out._consArrayType_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, p_168));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}