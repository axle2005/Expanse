package com.github.axle2005.expanse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("ALL")
public class UpdateChecker {


    /*

    Generic update checker that can be copied to all plugins. Only requirement is to Inject the PluginContainer in the Main Class and then call the UpdateChecker.checkRecommended() method using the created container.

     */
    private PluginContainer plugin;
    private static final String API_URL = "https://ore.spongepowered.org/api/v1/projects/";

    private UpdateChecker(PluginContainer plugin){
        this.plugin = plugin;
    }

    private static HttpsURLConnection getConnectionForCall(String pluginId)
            throws ClassCastException, IOException, URISyntaxException {
        String urlStr = API_URL + pluginId;


        URL url = new URL(urlStr);
        // Verify URL
        url.toURI();

        final HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
        applyDefaultSettings(httpsConnection);


        return httpsConnection;
    }

    private static void applyDefaultSettings(HttpsURLConnection connection) throws ProtocolException {
        final int defaultTimeout = 500;

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(defaultTimeout);
        connection.setReadTimeout(defaultTimeout);
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
    }

    static String checkRecommended(PluginContainer plugin) {

        try {
            Gson gson = new Gson();
            HttpsURLConnection connection = getConnectionForCall(plugin.getId());
            final String recommendedVersion =
                    gson.fromJson(
                            new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8),
                            JsonObject.class)
                            .get("recommended")
                            .getAsJsonObject()
                            .get("name")
                            .getAsString();

            if (!recommendedVersion.equals(plugin.getVersion().get())) {
                String mcVersion = Sponge.getPlatform().getMinecraftVersion().getName();
                if(recommendedVersion.contains(mcVersion)){
                    System.out.println();
                    registerListener(plugin);
                    return "There is a new version of " + plugin.getName() + " available on ORE";
                }

            }
            return plugin.getName() + " is up-to-date";


        } catch (ClassCastException | IOException | URISyntaxException | IllegalStateException e) {
            return "Error";
        }

    }

    private static void registerListener(PluginContainer pluginContainer){


        Sponge.getEventManager().registerListeners(pluginContainer,new UpdateChecker(pluginContainer));
    }

    @Listener
    public void onJoin(ClientConnectionEvent.Join event) {

        Player player = event.getTargetEntity();
        if(player.hasPermission(plugin.getId()+".admin")){
            String message = "["+plugin.getName()+"] There is an update available for this plugin on Ore";

            Task.Builder taskBuilder = Task.builder();
            taskBuilder.execute(
                    () -> {
                        player.sendMessage(Text.of(TextColors.AQUA, message));
                    }

            ).delayTicks(100).submit(plugin);
        }

    }
}
