/**
 * 
 */
package org.sugarj.driver.cli;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.sugarj.common.Environment;
import org.sugarj.common.Log;
import org.sugarj.common.path.AbsolutePath;
import org.sugarj.common.path.RelativePath;
import org.sugarj.common.path.RelativeSourceLocationPath;
import org.sugarj.common.path.SourceLocation;
import org.sugarj.driver.Driver;
import org.sugarj.driver.ModuleSystemCommands;
import org.sugarj.driver.PrintProgressMonitor;
import org.sugarj.driver.Result;
import org.sugarj.LanguageLibFactory;

/**
 * @author seba
 */
public class Main {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws Throwable {
    
    Environment environment = newConsoleEnvironment(args);
    
    Set<RelativeSourceLocationPath> allInputFiles = new HashSet<RelativeSourceLocationPath>();
    Set<RelativeSourceLocationPath> pendingInputFiles = new HashSet<RelativeSourceLocationPath>();
    
    try {
      String[] sources = DriverCLI.handleOptions(args, environment);
      
      for (String source : sources) {
        RelativeSourceLocationPath p = ModuleSystemCommands.locateSourceFile(source, environment.getSourcePath());
        if (p == null) {
          Log.log.logErr("Could not locate source file " + source);
          continue;
        }
        
        // cai 09.08.12
        // existence of language extension for file type is verified here
        // removed because we don't want to call LanguageRegistry
        // which depends on eclipse platform

        allInputFiles.add(p);
        pendingInputFiles.add(p);
      }
      
      IProgressMonitor monitor = new PrintProgressMonitor(System.out);
      
      for (final RelativeSourceLocationPath sourceFile : allInputFiles) {
        monitor.beginTask("compile " + sourceFile, IProgressMonitor.UNKNOWN);
        LanguageLibFactory lang = PILL.resolve(sourceFile.getFile());
        if(null==lang) continue;
        Result res = Driver.compile(sourceFile, monitor, lang);
        if (!DriverCLI.processResultCLI(res, sourceFile, new File(".").getAbsolutePath()))
          throw new RuntimeException("compilation of " + sourceFile + " failed");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } catch (CLIError e) {
      Log.log.log(e.getMessage());
      Log.log.log("");
      e.showUsage();
    }

    // kills all remaining subprocesses, if any
    // log.log("The extensible java compiler has done its job and says 'good bye'.");
    System.exit(0);
  }
  
  private static Environment newConsoleEnvironment(String[] args){
    Environment environment = new Environment();
    
    if (environment.getRoot()==null)
      environment.setRoot(new AbsolutePath("."));

    if (environment.getCacheDir() == null)
      environment.setCacheDir(new RelativePath(environment.getRoot(), ".sugarjcache"));

    if (environment.getSourcePath().isEmpty())
      environment.getSourcePath().add(new SourceLocation(new AbsolutePath("."), environment));
    return environment;
  }

}
