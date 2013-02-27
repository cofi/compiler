package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Sort$Var_1_0 extends Strategy 
{ 
  public static $Sort$Var_1_0 instance = new $Sort$Var_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_17)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SortVar_1_0");
    Fail126:
    { 
      IStrategoTerm w_111 = null;
      IStrategoTerm v_111 = null;
      if(term.getTermType() != IStrategoTerm.APPL || out._consSortVar_1 != ((IStrategoAppl)term).getConstructor())
        break Fail126;
      v_111 = term.getSubterm(0);
      IStrategoList annos113 = term.getAnnotations();
      w_111 = annos113;
      term = p_17.invoke(context, v_111);
      if(term == null)
        break Fail126;
      term = termFactory.annotateTerm(termFactory.makeAppl(out._consSortVar_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, w_111));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}