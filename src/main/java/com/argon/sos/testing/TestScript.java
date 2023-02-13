package com.argon.sos.testing;

import com.argon.sos.testing.test.AfterGameCreatedAvailabilityTest;
import com.argon.sos.testing.test.BeforeGameCreatedAvailabilityTest;
import com.argon.sos.testing.test.RunningGameAvailabilityTest;
import lombok.NoArgsConstructor;
import script.SCRIPT;
import snake2d.util.file.FileGetter;
import snake2d.util.file.FilePutter;
import util.info.INFO;

import java.io.IOException;

@NoArgsConstructor
@SuppressWarnings("unused") // used by the game via reflection
public final class TestScript implements SCRIPT {

	private final INFO info = new INFO("Testing Mod", "Tests for certain compatibility issues.");

	@Override
	public CharSequence name() {
		return info.name;
	}

	@Override
	public CharSequence desc() {
		return info.desc;
	}

	@Override
	public void initBeforeGameCreated() {
		BeforeGameCreatedAvailabilityTest.test();
	}

	@Override
	public SCRIPT_INSTANCE initAfterGameCreated() {
		AfterGameCreatedAvailabilityTest.test();
		return new Instance();
	}

	public static class Instance implements SCRIPT_INSTANCE {

		private boolean testRan = false;

		@Override
		public void update(double ds) {
			if (!testRan) {
				RunningGameAvailabilityTest.test();
				testRan = true;
			}
		}

		@Override
		public void save(FilePutter file) {

		}

		@Override
		public void load(FileGetter file) throws IOException {

		}
	}
}