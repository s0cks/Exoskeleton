package exoskeleton.common.core

import exoskeleton.api.Core

abstract class AbstractCore(val id: String)
extends Core{
  override def getID(): String ={
    return this.id;
  }
}