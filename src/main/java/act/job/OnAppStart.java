package act.job;

/*-
 * #%L
 * ACT Framework
 * %%
 * Copyright (C) 2014 - 2017 ActFramework
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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark a method to be a job that must be run after Application started up
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface OnAppStart {
    /**
     * <p>Indicate if the job should be run synchronously with application
     * or asynchronously.</p>
     * <p>Running job synchronously means the application
     * will not start servicing incoming requests until the job is finished.</p>
     * <p>Running job asynchronously means the job will start in a separate thread
     * and will not block the app from servicing incoming requests</p>
     * @return {@code true} if the annotated method shall be executed asynchronously
     *          or {@code false} if the method all be executed synchronously
     */
    boolean async() default false;

    /**
     * Specify the delay in seconds.
     *
     * Once this is set and the delay seconds is greater than 0, the job will
     * be start after `delay` seconds after app started. And the job will
     * be executed asynchronously.
     *
     * @return the delay time in seconds
     */
    int delayInSeconds() default -1;

    /**
     * Specify the ID of the scheduled job. Default value: empty string
     * @return the job id
     */
    String id() default "";
}
