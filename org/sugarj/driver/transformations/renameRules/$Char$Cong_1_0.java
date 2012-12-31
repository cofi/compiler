package org.sugarj.driver.transformations.renameRules;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Char$Cong_1_0 extends Strategy 
{ 
  public static $Char$Cong_1_0 instance = new $Char$Cong_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_15)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CharCong_1_0");
    Fail79:
    { 
      IStrategoTerm r_104 = null;
      IStrategoTerm q_104 = null;
      if(term.getTermType() != IStrategoTerm.APPL || out._consCharCong_1 != ((IStrategoAppl)term).getConstructor())
        break Fail79;
      q_104 = term.getSubterm(0);
      IStrategoList annos72 = term.getAnnotations();
      r_104 = annos72;
      term = e_15.invoke(context, q_104);
      if(term == null)
        break Fail79;
      term = termFactory.annotateTerm(termFactory.makeAppl(out._consCharCong_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, r_104));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}