package solutions.lhdev.carddemo.syncAdapters;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

public class SyncAdapter extends AbstractThreadedSyncAdapter {

    //contentResolver

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        //Instancie contentResolver
    }

    public SyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        //Instancie contentResolver
    }

    @Override
    public void onPerformSync(Account account,
                              Bundle bundle,
                              String authority,
                              ContentProviderClient contentProviderClient,
                              SyncResult syncResult)
    {
        Log.i(this.getClass().getSimpleName(), "Nos conectamos!");
    }
}
