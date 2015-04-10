package org.sugarj.driver.transformations.primitive;

import java.util.ArrayList;
import java.util.List;
import org.spoofax.interpreter.core.IContext;
import org.spoofax.interpreter.core.InterpreterException;
import org.spoofax.interpreter.library.AbstractPrimitive;
import org.spoofax.interpreter.stratego.Strategy;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.sugarj.common.ATermCommands;
import org.sugarj.driver.Driver;
import org.sugarj.util.Pair;


class ImportedInterfaces extends AbstractPrimitive {

  private Driver driver;
  
  public ImportedInterfaces(Driver driver) {
    super("SUGARJ_imported_interfaces", 0, 0);
    this.driver = driver;
  }

  @Override
  public boolean call(IContext context, Strategy[] svars, IStrategoTerm[] tvars) throws InterpreterException {
    context.setCurrent(makeInterfaceList());
    return true;
  }

  private IStrategoTerm makeInterfaceList() {
    List<IStrategoTerm> pairs = new ArrayList<IStrategoTerm>();
    for (Pair<IStrategoTerm, IStrategoTerm> p : driver.getImportedInterfaces()) {
        pairs.add(ATermCommands.makeTuple(p.a, p.b));
    }
    return ATermCommands.makeList("Pair", pairs);
  }
}