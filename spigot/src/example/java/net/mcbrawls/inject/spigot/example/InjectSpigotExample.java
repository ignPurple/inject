package net.mcbrawls.inject.spigot.example;

import io.netty.channel.ChannelHandlerContext;
import net.mcbrawls.inject.api.http.HttpByteBuf;
import net.mcbrawls.inject.api.http.HttpInjector;
import net.mcbrawls.inject.api.http.HttpRequest;
import net.mcbrawls.inject.spigot.InjectSpigot;
import org.bukkit.plugin.java.JavaPlugin;

public class InjectSpigotExample extends JavaPlugin {
    static class MyEpicHttpInjector extends HttpInjector {
        @Override
        public HttpByteBuf intercept(ChannelHandlerContext ctx, HttpRequest request) {
            HttpByteBuf buf = HttpByteBuf.httpBuf(ctx);
            buf.writeStatusLine("1.1", 200, "OK");
            buf.writeText("Hello, from Minecraft!");
            return buf;
        }
    }

    @Override
    public void onEnable() {
        InjectSpigot.INSTANCE.registerInjector(new MyEpicHttpInjector());
    }
}