package exoskeleton.core

import java.util

import com.google.common.eventbus.EventBus
import cpw.mods.fml.common.{LoadController, ModMetadata, DummyModContainer}

class EXOModContainer
extends DummyModContainer(new ModMetadata()){
  val meta = this.getMetadata;
  meta.modId = "EXO|Core";
  meta.name = "Exoskeleton|Core";
  meta.version = "1.0.0.0";
  meta.credits = "Asyncronous";
  meta.authorList = util.Arrays.asList("Asyncronous");
  meta.description = "";
  meta.url = "";
  meta.updateUrl = "";
  meta.screenshots = Array();
  meta.logoFile = "";

  override def registerBus(bus: EventBus, controller: LoadController): Boolean ={
    bus.register(this);
    return true;
  }
}