package io.github.asyncronous.exoskeleton.core

import io.github.asyncronous.exoskeleton.api.Core

abstract class AbstractCore(val id: String)
extends Core{
  override def getID(): String ={
    return this.id;
  }
}