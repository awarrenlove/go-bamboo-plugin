/*
 * #%L
 * Go Plugin for Bamboo
 * %%
 * Copyright (C) 2016 Andrew Warren-Love
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.handcraftedbits.bamboo.plugin.go.task.glide;

import com.atlassian.bamboo.process.EnvironmentVariableAccessor;
import com.atlassian.bamboo.v2.build.agent.capability.CapabilityContext;
import com.atlassian.struts.TextProvider;
import com.handcraftedbits.bamboo.plugin.go.task.common.AbstractGoExecutableTaskConfigurator;
import org.jetbrains.annotations.NotNull;

public final class GoGlideTaskConfigurator extends AbstractGoExecutableTaskConfigurator {
     public GoGlideTaskConfigurator (@NotNull final CapabilityContext capabilityContext,
                                    @NotNull final EnvironmentVariableAccessor environmentVariableAccessor,
                                    @NotNull final TextProvider textProvider) {
          super(capabilityContext, environmentVariableAccessor, textProvider, false);

          addParameter(GoGlideTaskConfiguration.PARAM_GLIDE_EXEC, "");
          addParameter(GoGlideTaskConfiguration.PARAM_GOPATH, "");
     }
}