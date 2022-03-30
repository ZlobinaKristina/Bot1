package core;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface GeneralConfig extends Config {

    @Key("browser")
    String browser();

    @Key("timeout")
    int timeout();
}