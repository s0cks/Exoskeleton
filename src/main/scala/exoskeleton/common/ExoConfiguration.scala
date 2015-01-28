package exoskeleton.common

import java.io.File

import net.minecraftforge.common.config.Configuration

object ExoConfiguration{
  var adv_vision: Boolean = false;
  private var config: Configuration = null;

  def init(file: File): Unit ={
    this.config = new Configuration(file);
    this.config.load();
    this.adv_vision = this.config.getBoolean("settings", "adv_vision", true, "Enable for texture overrides");
    this.config.save();
  }

  def save(): Unit ={
    this.config.save();
  }
}