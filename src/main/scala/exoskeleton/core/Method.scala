package exoskeleton.core

class Method(val deobf: String, val obf: String){
  def is(str: String): Boolean={
    return str.equalsIgnoreCase(this.deobf) || str.equalsIgnoreCase(this.obf);
  }
}