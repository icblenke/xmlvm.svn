package org.newdawn.testgame;

import java.io.IOException;

import org.newdawn.game.Game;
import org.newdawn.game.GameConfig;
import org.newdawn.game.GameContext;
import org.newdawn.game.GameState;

public class TestGame implements Game {
	private InGameState state = new InGameState();

	public GameState getInitialState(GameContext context) {
		return state;
	}

	public GameState[] getStates(GameContext context) {
		return new GameState[] {state};
	}

	public void init(GameContext context) {
		try {
			Images.init(context);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void preload(GameConfig config) throws IOException {
	}

	public boolean requiresKeyboardFocus() {
		return false;
	}

}
