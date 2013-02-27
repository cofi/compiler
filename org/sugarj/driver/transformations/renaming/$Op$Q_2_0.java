package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Op$Q_2_0 extends Strategy 
{ 
  public static $Op$Q_2_0 instance = new $Op$Q_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_18, Strategy k_18)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("OpQ_2_0");
    Fail142:
    { 
      IStrategoTerm d_114 = null;
      IStrategoTerm b_114 = null;
      IStrategoTerm c_114 = null;
      IStrategoTerm e_114 = null;
      if(term.getTermType() != IStrategoTerm.APPL || out._consOpQ_2 != ((IStrategoAppl)term).getConstructor())
        break Fail142;
      b_114 = term.getSubterm(0);
      c_114 = term.getSubterm(1);
      IStrategoList annos128 = term.getAnnotations();
      d_114 = annos128;
      term = j_18.invoke(context, b_114);
      if(term == null)
        break Fail142;
      e_114 = term;
      term = k_18.invoke(context, c_114);
      if(term == null)
        break Fail142;
      term = termFactory.annotateTerm(termFactory.makeAppl(out._consOpQ_2, new IStrategoTerm[]{e_114, term}), checkListAnnos(termFactory, d_114));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}