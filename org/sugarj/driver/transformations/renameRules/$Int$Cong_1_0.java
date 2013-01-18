package org.sugarj.driver.transformations.renameRules;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Int$Cong_1_0 extends Strategy 
{ 
  public static $Int$Cong_1_0 instance = new $Int$Cong_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_15)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("IntCong_1_0");
    Fail81:
    { 
      IStrategoTerm x_104 = null;
      IStrategoTerm w_104 = null;
      if(term.getTermType() != IStrategoTerm.APPL || out._consIntCong_1 != ((IStrategoAppl)term).getConstructor())
        break Fail81;
      w_104 = term.getSubterm(0);
      IStrategoList annos74 = term.getAnnotations();
      x_104 = annos74;
      term = g_15.invoke(context, w_104);
      if(term == null)
        break Fail81;
      term = termFactory.annotateTerm(termFactory.makeAppl(out._consIntCong_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, x_104));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}