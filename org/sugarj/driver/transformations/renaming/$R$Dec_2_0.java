package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $R$Dec_2_0 extends Strategy 
{ 
  public static $R$Dec_2_0 instance = new $R$Dec_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_40, Strategy r_40)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("RDec_2_0");
    Fail249:
    { 
      IStrategoTerm x_174 = null;
      IStrategoTerm v_174 = null;
      IStrategoTerm w_174 = null;
      IStrategoTerm y_174 = null;
      if(term.getTermType() != IStrategoTerm.APPL || out._consRDec_2 != ((IStrategoAppl)term).getConstructor())
        break Fail249;
      v_174 = term.getSubterm(0);
      w_174 = term.getSubterm(1);
      IStrategoList annos196 = term.getAnnotations();
      x_174 = annos196;
      term = q_40.invoke(context, v_174);
      if(term == null)
        break Fail249;
      y_174 = term;
      term = r_40.invoke(context, w_174);
      if(term == null)
        break Fail249;
      term = termFactory.annotateTerm(termFactory.makeAppl(out._consRDec_2, new IStrategoTerm[]{y_174, term}), checkListAnnos(termFactory, x_174));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}