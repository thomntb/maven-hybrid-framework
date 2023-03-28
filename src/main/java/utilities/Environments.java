package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:environmentConfig/${env}.properties" })
public interface Environments extends Config {
	@Key("app.url")
	String appUrl();

	@Key("app.username")
	String appUserName();

	@Key("app.password")
	String appPassword();

	@Key("db.host")
	String dbHost();

	@Key("db.username")
	String dbUsername();

	@Key("db.password")
	String dbPassword();

}
