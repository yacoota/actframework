package me.tongfei.progressbar.wrapped;

/*-
 * #%L
 * TongFei ProgressBar
 * %%
 * Copyright (C) 2014 - 2018 Tongfei Chen
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

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Tongfei Chen
 * @since 0.6.0
 */
public class ProgressBarWrappedIterable<T> implements Iterable<T> {

    Iterable<T> underlying;
    String task;

    public ProgressBarWrappedIterable(Iterable<T> underlying, String task) {
        this.underlying = underlying;
        this.task = task;
    }

    @Override
    public Iterator<T> iterator() {
        return new ProgressBarWrappedIterator<>(
                underlying.iterator(),
                task,
                sizeOf(underlying)
        );
    }

    private long sizeOf(Iterable<?> iterable) {
        // if size unknown, -1, hence indefinite progress bar
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return -1;
    }

}
