/*
 * Copyright (C) 2015 The Android Open Source Project
 *
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
 * limitations under the License
 */

package com.android.tv.dvr;

import android.support.annotation.MainThread;

import com.android.tv.dvr.ScheduledRecording.RecordingState;

/**
 * Full data manager.
 *
 * <p>The following operations need to be synced with permanent storage. The following commands are
 * for internal use only. Do not call them from UI directly.
 */
@MainThread
interface WritableDvrDataManager extends DvrDataManager {
    /**
     * Adds new recordings.
     */
    void addScheduledRecording(ScheduledRecording... scheduledRecordings);

    /**
     * Adds new series recordings.
     */
    void addSeriesRecording(SeriesRecording... seriesRecordings);

    /**
     * Removes recordings.
     */
    void removeScheduledRecording(ScheduledRecording... scheduledRecordings);

    /**
     * Removes series recordings.
     *
     * <p>Note that the finished or failed schedules are not deleted.
     */
    void removeSeriesRecording(SeriesRecording... seasonSchedules);

    /**
     * Updates existing recordings.
     */
    void updateScheduledRecording(ScheduledRecording... scheduledRecordings);

    /**
     * Updates existing series recordings.
     */
    void updateSeriesRecording(SeriesRecording... seriesRecordings);

    /**
     * Changes the state of the recording.
     */
    void changeState(ScheduledRecording scheduledRecording, @RecordingState int newState);
}
