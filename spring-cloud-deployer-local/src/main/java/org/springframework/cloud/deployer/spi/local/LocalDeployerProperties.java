/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.deployer.spi.local;

import java.io.File;
import java.nio.file.Path;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for the local deployer.
 *
 * @author Eric Bottard
 * @author Mark Fisher
 */
@ConfigurationProperties(prefix = "deployer.local")
public class LocalDeployerProperties {

	/**
	 * Directory in which all created processes will run and create log files.
	 */
	private Path workingDirectoriesRoot = new File(System.getProperty("java.io.tmpdir")).toPath();

	/**
	 * Whether to delete created files and directories on JVM exit.
	 */
	private boolean deleteFilesOnExit = true;

	/**
	 * Array of regular expression patterns for environment variables that
	 * should be passed to launched applications.
	 */
	private String[] envVarsToInherit = { "TMP", "LANG", "LANGUAGE", "LC_.*" };

	/**
	 * The command to run java.
	 */
	private String javaCmd = "java";

	/**
	 * Maximum number of seconds to wait for application shutdown
	 * via the {@code /shutdown} endpoint.
	 */
	private int shutdownTimeout = 30;


	public String getJavaCmd() {
		return javaCmd;
	}

	public void setJavaCmd(String javaCmd) {
		this.javaCmd = javaCmd;
	}

	public Path getWorkingDirectoriesRoot() {
		return workingDirectoriesRoot;
	}

	public void setWorkingDirectoriesRoot(Path workingDirectoriesRoot) {
		this.workingDirectoriesRoot = workingDirectoriesRoot;
	}

	public boolean isDeleteFilesOnExit() {
		return deleteFilesOnExit;
	}

	public void setDeleteFilesOnExit(boolean deleteFilesOnExit) {
		this.deleteFilesOnExit = deleteFilesOnExit;
	}

	public String[] getEnvVarsToInherit() {
		return envVarsToInherit;
	}

	public void setEnvVarsToInherit(String[] envVarsToInherit) {
		this.envVarsToInherit = envVarsToInherit;
	}

	public int getShutdownTimeout() {
		return shutdownTimeout;
	}

	public LocalDeployerProperties setShutdownTimeout(int shutdownTimeout) {
		this.shutdownTimeout = shutdownTimeout;
		return this;
	}

}
