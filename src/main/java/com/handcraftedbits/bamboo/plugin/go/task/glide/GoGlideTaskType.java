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
import com.atlassian.bamboo.task.TaskContext;
import com.atlassian.bamboo.task.TaskException;
import com.atlassian.bamboo.task.TaskResult;
import com.atlassian.bamboo.task.TaskResultBuilder;
import com.atlassian.bamboo.v2.build.agent.capability.CapabilityContext;
import com.atlassian.struts.TextProvider;
import com.atlassian.utils.process.ExternalProcess;
import com.handcraftedbits.bamboo.plugin.go.task.common.AbstractGoTaskType;
import com.handcraftedbits.bamboo.plugin.go.task.common.ProcessHelper;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class GoGlideTaskType extends AbstractGoTaskType {
     public GoGlideTaskType (@NotNull final CapabilityContext capabilityContext,
                            @NotNull final EnvironmentVariableAccessor environmentVariableAccessor,
                            @NotNull final TextProvider textProvider) {
          super(capabilityContext, environmentVariableAccessor, textProvider);
     }

     @NotNull
     @Override
     public TaskResult execute (@NotNull final TaskContext taskContext) throws TaskException {
          final List<String> commandLine = new LinkedList<>();
          final GoGlideTaskConfiguration configuration = new GoGlideTaskConfiguration(getTaskHelper(), taskContext);
          final ExternalProcess process;
          final ProcessHelper processHelper = getTaskHelper().createProcessHelper(taskContext);

          commandLine.add(configuration.getGlideExecutable());
          commandLine.add("install");

          final Map<String, String> env = new HashMap<>();
          env.put("GOPATH", configuration.getGoPath());

          process = processHelper.executeProcess(commandLine, configuration.getSourcePath(), env);

          return TaskResultBuilder.newBuilder(taskContext).checkReturnCode(process, 0).build();
     }
}
