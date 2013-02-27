package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $S$Def$No$Args_2_0 extends Strategy 
{ 
  public static $S$Def$No$Args_2_0 instance = new $S$Def$No$Args_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_12, Strategy r_12)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SDefNoArgs_2_0");
    Fail53:
    { 
      IStrategoTerm e_98 = null;
      IStrategoTerm c_98 = null;
      IStrategoTerm d_98 = null;
      IStrategoTerm f_98 = null;
      if(term.getTermType() != IStrategoTerm.APPL || out._consSDefNoArgs_2 != ((IStrategoAppl)term).getConstructor())
        break Fail53;
      c_98 = term.getSubterm(0);
      d_98 = term.getSubterm(1);
      IStrategoList annos43 = term.getAnnotations();
      e_98 = annos43;
      term = q_12.invoke(context, c_98);
      if(term == null)
        break Fail53;
      f_98 = term;
      term = r_12.invoke(context, d_98);
      if(term == null)
        break Fail53;
      term = termFactory.annotateTerm(termFactory.makeAppl(out._consSDefNoArgs_2, new IStrategoTerm[]{f_98, term}), checkListAnnos(termFactory, e_98));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}