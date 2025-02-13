package naaaaagi.alwaysshowchat.mixin.client;

import naaaaagi.alwaysshowchat.AlwaysShowChatClient;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(ChatHud.class)
public class AlwaysShowChatMixin {
    // Always set the focused argument of ChatHud.render() to true
    @ModifyVariable(at = @At("HEAD"), method = "render(Lnet/minecraft/client/gui/DrawContext;IIIZ)V")
    private boolean init(boolean arg) {
        return AlwaysShowChatClient.state;
    }
}