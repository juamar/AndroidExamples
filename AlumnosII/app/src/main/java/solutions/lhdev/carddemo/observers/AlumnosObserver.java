package solutions.lhdev.carddemo.observers;

import android.accounts.Account;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class AlumnosObserver extends ContentObserver {

    public String authority;
    private Account account;

    public AlumnosObserver(Account account, String authority) {
        super(null);
        this.authority = authority;
        this.account = account;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        /*
         * Invoke the method signature available as of
         * Android platform version 4.1, with a null URI.
         */
        onChange(selfChange, null);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        /*
         * Ask the framework to run your sync adapter.
         * To maintain backward compatibility, assume that
         * changeUri is null.
         */
        Log.i(this.getClass().getSimpleName(), "account="+account.type + " - authority=" + authority);
        ContentResolver.requestSync(account, authority, Bundle.EMPTY);
    }
}
