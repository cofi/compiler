package org.sugarj.driver.transformations.extraction;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class no_attrs_0_0 extends Strategy 
{ 
  public static no_attrs_0_0 instance = new no_attrs_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail232:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || extraction._consno_attrs_0 != ((IStrategoAppl)term).getConstructor())
        break Fail232;
      if(true)
        return term;
    }
    context.push("no_attrs_0_0");
    context.popOnFailure();
    return null;
  }
}