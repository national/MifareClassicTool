/*
 * Copyright 2013 Gerhard Klostermeier
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package de.syss.MifareClassicTool.Activitys;

import de.syss.MifareClassicTool.Common;
import android.app.Activity;
import android.content.Intent;

/**
 * An Activity implementing the NFC foreground dispatch system overwriting
 * onResume() and onPause(). New Intents will be treated as new Tags.
 * @see Common#enableNfcForegroundDispatch(Activity)
 * @see Common#disableNfcForegroundDispatch(Activity)
 * @see Common#treatAsNewTag(Intent, android.content.Context)
 * @author Gerhard Klostermeier
 *
 */
public abstract class BasicActivity extends Activity {

    /**
     * Enable NFC foreground dispatch system.
     * @see Common#disableNfcForegroundDispatch(Activity)
     */
    @Override
    public void onResume() {
        super.onResume();
        Common.enableNfcForegroundDispatch(this);
    }

    /**
     * Disable NFC foreground dispatch system.
     * @see Common#disableNfcForegroundDispatch(Activity)
     */
    @Override
    public void onPause() {
        super.onPause();
        Common.disableNfcForegroundDispatch(this);
    }

    /**
     * Handle new Intent as a new tag Intent.
     * @see Common#treatAsNewTag(Intent, android.content.Context)
     */
    @Override
    public void onNewIntent(Intent intent) {
        Common.treatAsNewTag(intent, this);
    }
}
