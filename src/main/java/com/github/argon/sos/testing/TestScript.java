package com.github.argon.sos.testing;

import com.github.argon.sos.testing.log.Logger;
import com.github.argon.sos.testing.log.Loggers;
import com.github.argon.sos.testing.test.AfterGameCreatedAvailabilityTest;
import com.github.argon.sos.testing.test.BeforeGameCreatedAvailabilityTest;
import com.github.argon.sos.testing.test.RunningGameAvailabilityTest;
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

    private final static Logger log = Loggers.getLogger(TestScript.class);

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
		log.info("Running %s", BeforeGameCreatedAvailabilityTest.class.getSimpleName());
		BeforeGameCreatedAvailabilityTest.test();
		log.info("Test OK");
	}

	@Override
	public SCRIPT_INSTANCE initAfterGameCreated() {
		log.info("Running %s", AfterGameCreatedAvailabilityTest.class.getSimpleName());
		AfterGameCreatedAvailabilityTest.test();
		log.info("Test OK");
		return new Instance();
	}

	public static class Instance implements SCRIPT_INSTANCE {

		private boolean testRan = false;

		@Override
		public void update(double ds) {
			if (!testRan) {
				log.info("Running %s", RunningGameAvailabilityTest.class.getSimpleName());
				RunningGameAvailabilityTest.test();
				log.info("Test OK");
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