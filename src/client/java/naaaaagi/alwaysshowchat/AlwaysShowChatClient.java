package naaaaagi.alwaysshowchat;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class AlwaysShowChatClient implements ClientModInitializer {
	public static boolean state = true;
	// Register key bindings
	public KeyBinding TOGGLE_SETTING = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"Toggle Setting",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_F7,
			"Always Show Chat"
	));

	@Override
	public void onInitializeClient() {
		// Register event for toggling on/off
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (TOGGLE_SETTING.wasPressed()) {
				toggleSetting();
			}
		});
	}

	private void toggleSetting() {
		System.out.println("toggled!");
		state = !state;
	}
}