package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Super$Field_1_0 extends Strategy 
{ 
  public static $Super$Field_1_0 instance = new $Super$Field_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_29)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SuperField_1_0");
    Fail66:
    { 
      IStrategoTerm t_132 = null;
      IStrategoTerm q_132 = null;
      if(term.getTermType() != IStrategoTerm.APPL || out._consSuperField_1 != ((IStrategoAppl)term).getConstructor())
        break Fail66;
      q_132 = term.getSubterm(0);
      IStrategoList annos42 = term.getAnnotations();
      t_132 = annos42;
      term = f_29.invoke(context, q_132);
      if(term == null)
        break Fail66;
      term = termFactory.annotateTerm(termFactory.makeAppl(out._consSuperField_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, t_132));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}