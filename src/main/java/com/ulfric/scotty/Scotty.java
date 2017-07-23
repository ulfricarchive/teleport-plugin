package com.ulfric.scotty;

import com.ulfric.platform.Plugin;

public class Scotty extends Plugin {

	public Scotty() {
		install(ScottyContainer.class);
	}

}