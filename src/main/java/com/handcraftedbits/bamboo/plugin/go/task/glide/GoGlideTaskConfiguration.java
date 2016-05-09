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

import com.atlassian.bamboo.task.TaskContext;
import com.handcraftedbits.bamboo.plugin.go.task.common.GoPackageAwareTaskConfiguration;
import com.handcraftedbits.bamboo.plugin.go.task.common.GoTaskHelper;
import org.jetbrains.annotations.NotNull;

final class GoGlideTaskConfiguration extends GoPackageAwareTaskConfiguration {
     static final String PARAM_GLIDE_EXEC = "glideExec";
     static final String PARAM_GOPATH = "goPath";

     GoGlideTaskConfiguration (@NotNull final GoTaskHelper taskHelper, @NotNull final TaskContext taskContext) {
          super(taskHelper, taskContext);
     }

     @NotNull
     String getGlideExecutable () {
          return getTaskContext().getConfigurationMap().get(GoGlideTaskConfiguration.PARAM_GLIDE_EXEC);
     }

     @NotNull
     String getGoPath () {
          return getTaskContext().getConfigurationMap().get(GoGlideTaskConfiguration.PARAM_GOPATH);
     }
}
