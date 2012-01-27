package org.sugarj.driver.sourcefilecontent;

import java.util.LinkedList;
import java.util.List;

import org.sugarj.driver.Environment;
import org.sugarj.driver.FileCommands;
import org.sugarj.driver.path.RelativePath;

/**
 * @author seba
 *
 */
public class JavaSourceFileContent implements ISourceFileContent {
  private static final long serialVersionUID = 1164576595940328804L;

  String packageDecl;
  List<String> imports = new LinkedList<String>();
  boolean importsOptional;
  List<String> bodyDecls = new LinkedList<String>();
  
  public JavaSourceFileContent() {
  }
  
  public void setPackageDecl(String packageDecl) {
    this.packageDecl = packageDecl;
  }
  
  public void addImport(String imp) {
    imports.add(imp);
  }
  
  public void setOptionalImport(boolean isOptional) {
    this.importsOptional = isOptional;
  }
  
  public void addBodyDecl(String bodyDecl) {
    bodyDecls.add(bodyDecl);
  }
  
  public String getCode(List<RelativePath> generatedClasses) throws ClassNotFoundException {
    List<String> classes = new LinkedList<String>();
    for (RelativePath p : generatedClasses)
      classes.add(FileCommands.dropExtension(p.getRelativePath()).replace(Environment.sep, "."));
    
    StringBuilder code = new StringBuilder();
    code.append(packageDecl);
    code.append('\n');
    
    for (String imp : imports)
      if (classes.contains(imp))
        code.append("import ").append(imp).append(";\n");
      else if (!importsOptional)
        throw new ClassNotFoundException(imp);
    
    for (String bodyDecl : bodyDecls)
      code.append(bodyDecl);
    
    return code.toString();
  }
  
  public int hashCode() {
    return packageDecl.hashCode() + imports.hashCode() + bodyDecls.hashCode();
  }
  
  public boolean equals(Object o) {
    if (!(o instanceof JavaSourceFileContent))
      return false;
    
    JavaSourceFileContent other = (JavaSourceFileContent) o;
    return other.packageDecl.equals(packageDecl) &&
           other.imports.equals(imports) &&
           other.importsOptional == importsOptional &&
           other.bodyDecls.equals(bodyDecls);
  }
}
