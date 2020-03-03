package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_tererai_weatherapp_Model_FavoritesDataRealmProxy extends com.tererai.weatherapp.Model.FavoritesData
    implements RealmObjectProxy, com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface {

    static final class FavoritesDataColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long IDIndex;
        long CityIndex;
        long CurrentConditionIndex;
        long MinTempIndex;
        long CurrentTempIndex;
        long MaxTempIndex;

        FavoritesDataColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("FavoritesData");
            this.IDIndex = addColumnDetails("ID", "ID", objectSchemaInfo);
            this.CityIndex = addColumnDetails("City", "City", objectSchemaInfo);
            this.CurrentConditionIndex = addColumnDetails("CurrentCondition", "CurrentCondition", objectSchemaInfo);
            this.MinTempIndex = addColumnDetails("MinTemp", "MinTemp", objectSchemaInfo);
            this.CurrentTempIndex = addColumnDetails("CurrentTemp", "CurrentTemp", objectSchemaInfo);
            this.MaxTempIndex = addColumnDetails("MaxTemp", "MaxTemp", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        FavoritesDataColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new FavoritesDataColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final FavoritesDataColumnInfo src = (FavoritesDataColumnInfo) rawSrc;
            final FavoritesDataColumnInfo dst = (FavoritesDataColumnInfo) rawDst;
            dst.IDIndex = src.IDIndex;
            dst.CityIndex = src.CityIndex;
            dst.CurrentConditionIndex = src.CurrentConditionIndex;
            dst.MinTempIndex = src.MinTempIndex;
            dst.CurrentTempIndex = src.CurrentTempIndex;
            dst.MaxTempIndex = src.MaxTempIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private FavoritesDataColumnInfo columnInfo;
    private ProxyState<com.tererai.weatherapp.Model.FavoritesData> proxyState;

    com_tererai_weatherapp_Model_FavoritesDataRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FavoritesDataColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.tererai.weatherapp.Model.FavoritesData>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.IDIndex);
    }

    @Override
    public void realmSet$ID(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'ID' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$City() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.CityIndex);
    }

    @Override
    public void realmSet$City(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.CityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.CityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.CityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.CityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$CurrentCondition() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.CurrentConditionIndex);
    }

    @Override
    public void realmSet$CurrentCondition(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.CurrentConditionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.CurrentConditionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.CurrentConditionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.CurrentConditionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$MinTemp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.MinTempIndex);
    }

    @Override
    public void realmSet$MinTemp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.MinTempIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.MinTempIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.MinTempIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.MinTempIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$CurrentTemp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.CurrentTempIndex);
    }

    @Override
    public void realmSet$CurrentTemp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.CurrentTempIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.CurrentTempIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.CurrentTempIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.CurrentTempIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$MaxTemp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.MaxTempIndex);
    }

    @Override
    public void realmSet$MaxTemp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.MaxTempIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.MaxTempIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.MaxTempIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.MaxTempIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("FavoritesData", 6, 0);
        builder.addPersistedProperty("ID", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("City", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("CurrentCondition", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("MinTemp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("CurrentTemp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("MaxTemp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static FavoritesDataColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new FavoritesDataColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "FavoritesData";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "FavoritesData";
    }

    @SuppressWarnings("cast")
    public static com.tererai.weatherapp.Model.FavoritesData createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.tererai.weatherapp.Model.FavoritesData obj = null;
        if (update) {
            Table table = realm.getTable(com.tererai.weatherapp.Model.FavoritesData.class);
            FavoritesDataColumnInfo columnInfo = (FavoritesDataColumnInfo) realm.getSchema().getColumnInfo(com.tererai.weatherapp.Model.FavoritesData.class);
            long pkColumnIndex = columnInfo.IDIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("ID")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("ID"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.tererai.weatherapp.Model.FavoritesData.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_tererai_weatherapp_Model_FavoritesDataRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("ID")) {
                if (json.isNull("ID")) {
                    obj = (io.realm.com_tererai_weatherapp_Model_FavoritesDataRealmProxy) realm.createObjectInternal(com.tererai.weatherapp.Model.FavoritesData.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_tererai_weatherapp_Model_FavoritesDataRealmProxy) realm.createObjectInternal(com.tererai.weatherapp.Model.FavoritesData.class, json.getString("ID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'ID'.");
            }
        }

        final com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface objProxy = (com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) obj;
        if (json.has("City")) {
            if (json.isNull("City")) {
                objProxy.realmSet$City(null);
            } else {
                objProxy.realmSet$City((String) json.getString("City"));
            }
        }
        if (json.has("CurrentCondition")) {
            if (json.isNull("CurrentCondition")) {
                objProxy.realmSet$CurrentCondition(null);
            } else {
                objProxy.realmSet$CurrentCondition((String) json.getString("CurrentCondition"));
            }
        }
        if (json.has("MinTemp")) {
            if (json.isNull("MinTemp")) {
                objProxy.realmSet$MinTemp(null);
            } else {
                objProxy.realmSet$MinTemp((String) json.getString("MinTemp"));
            }
        }
        if (json.has("CurrentTemp")) {
            if (json.isNull("CurrentTemp")) {
                objProxy.realmSet$CurrentTemp(null);
            } else {
                objProxy.realmSet$CurrentTemp((String) json.getString("CurrentTemp"));
            }
        }
        if (json.has("MaxTemp")) {
            if (json.isNull("MaxTemp")) {
                objProxy.realmSet$MaxTemp(null);
            } else {
                objProxy.realmSet$MaxTemp((String) json.getString("MaxTemp"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.tererai.weatherapp.Model.FavoritesData createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.tererai.weatherapp.Model.FavoritesData obj = new com.tererai.weatherapp.Model.FavoritesData();
        final com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface objProxy = (com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("ID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ID(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("City")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$City((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$City(null);
                }
            } else if (name.equals("CurrentCondition")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CurrentCondition((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$CurrentCondition(null);
                }
            } else if (name.equals("MinTemp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$MinTemp((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$MinTemp(null);
                }
            } else if (name.equals("CurrentTemp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CurrentTemp((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$CurrentTemp(null);
                }
            } else if (name.equals("MaxTemp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$MaxTemp((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$MaxTemp(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'ID'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_tererai_weatherapp_Model_FavoritesDataRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.tererai.weatherapp.Model.FavoritesData.class), false, Collections.<String>emptyList());
        io.realm.com_tererai_weatherapp_Model_FavoritesDataRealmProxy obj = new io.realm.com_tererai_weatherapp_Model_FavoritesDataRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.tererai.weatherapp.Model.FavoritesData copyOrUpdate(Realm realm, FavoritesDataColumnInfo columnInfo, com.tererai.weatherapp.Model.FavoritesData object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.tererai.weatherapp.Model.FavoritesData) cachedRealmObject;
        }

        com.tererai.weatherapp.Model.FavoritesData realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.tererai.weatherapp.Model.FavoritesData.class);
            long pkColumnIndex = columnInfo.IDIndex;
            String value = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$ID();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_tererai_weatherapp_Model_FavoritesDataRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.tererai.weatherapp.Model.FavoritesData copy(Realm realm, FavoritesDataColumnInfo columnInfo, com.tererai.weatherapp.Model.FavoritesData newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.tererai.weatherapp.Model.FavoritesData) cachedRealmObject;
        }

        com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface realmObjectSource = (com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) newObject;

        Table table = realm.getTable(com.tererai.weatherapp.Model.FavoritesData.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.IDIndex, realmObjectSource.realmGet$ID());
        builder.addString(columnInfo.CityIndex, realmObjectSource.realmGet$City());
        builder.addString(columnInfo.CurrentConditionIndex, realmObjectSource.realmGet$CurrentCondition());
        builder.addString(columnInfo.MinTempIndex, realmObjectSource.realmGet$MinTemp());
        builder.addString(columnInfo.CurrentTempIndex, realmObjectSource.realmGet$CurrentTemp());
        builder.addString(columnInfo.MaxTempIndex, realmObjectSource.realmGet$MaxTemp());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_tererai_weatherapp_Model_FavoritesDataRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.tererai.weatherapp.Model.FavoritesData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tererai.weatherapp.Model.FavoritesData.class);
        long tableNativePtr = table.getNativePtr();
        FavoritesDataColumnInfo columnInfo = (FavoritesDataColumnInfo) realm.getSchema().getColumnInfo(com.tererai.weatherapp.Model.FavoritesData.class);
        long pkColumnIndex = columnInfo.IDIndex;
        String primaryKeyValue = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$ID();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$City = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$City();
        if (realmGet$City != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CityIndex, rowIndex, realmGet$City, false);
        }
        String realmGet$CurrentCondition = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$CurrentCondition();
        if (realmGet$CurrentCondition != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CurrentConditionIndex, rowIndex, realmGet$CurrentCondition, false);
        }
        String realmGet$MinTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$MinTemp();
        if (realmGet$MinTemp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MinTempIndex, rowIndex, realmGet$MinTemp, false);
        }
        String realmGet$CurrentTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$CurrentTemp();
        if (realmGet$CurrentTemp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CurrentTempIndex, rowIndex, realmGet$CurrentTemp, false);
        }
        String realmGet$MaxTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$MaxTemp();
        if (realmGet$MaxTemp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MaxTempIndex, rowIndex, realmGet$MaxTemp, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tererai.weatherapp.Model.FavoritesData.class);
        long tableNativePtr = table.getNativePtr();
        FavoritesDataColumnInfo columnInfo = (FavoritesDataColumnInfo) realm.getSchema().getColumnInfo(com.tererai.weatherapp.Model.FavoritesData.class);
        long pkColumnIndex = columnInfo.IDIndex;
        com.tererai.weatherapp.Model.FavoritesData object = null;
        while (objects.hasNext()) {
            object = (com.tererai.weatherapp.Model.FavoritesData) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$ID();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$City = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$City();
            if (realmGet$City != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CityIndex, rowIndex, realmGet$City, false);
            }
            String realmGet$CurrentCondition = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$CurrentCondition();
            if (realmGet$CurrentCondition != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CurrentConditionIndex, rowIndex, realmGet$CurrentCondition, false);
            }
            String realmGet$MinTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$MinTemp();
            if (realmGet$MinTemp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MinTempIndex, rowIndex, realmGet$MinTemp, false);
            }
            String realmGet$CurrentTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$CurrentTemp();
            if (realmGet$CurrentTemp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CurrentTempIndex, rowIndex, realmGet$CurrentTemp, false);
            }
            String realmGet$MaxTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$MaxTemp();
            if (realmGet$MaxTemp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MaxTempIndex, rowIndex, realmGet$MaxTemp, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.tererai.weatherapp.Model.FavoritesData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tererai.weatherapp.Model.FavoritesData.class);
        long tableNativePtr = table.getNativePtr();
        FavoritesDataColumnInfo columnInfo = (FavoritesDataColumnInfo) realm.getSchema().getColumnInfo(com.tererai.weatherapp.Model.FavoritesData.class);
        long pkColumnIndex = columnInfo.IDIndex;
        String primaryKeyValue = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$ID();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$City = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$City();
        if (realmGet$City != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CityIndex, rowIndex, realmGet$City, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.CityIndex, rowIndex, false);
        }
        String realmGet$CurrentCondition = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$CurrentCondition();
        if (realmGet$CurrentCondition != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CurrentConditionIndex, rowIndex, realmGet$CurrentCondition, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.CurrentConditionIndex, rowIndex, false);
        }
        String realmGet$MinTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$MinTemp();
        if (realmGet$MinTemp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MinTempIndex, rowIndex, realmGet$MinTemp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.MinTempIndex, rowIndex, false);
        }
        String realmGet$CurrentTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$CurrentTemp();
        if (realmGet$CurrentTemp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CurrentTempIndex, rowIndex, realmGet$CurrentTemp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.CurrentTempIndex, rowIndex, false);
        }
        String realmGet$MaxTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$MaxTemp();
        if (realmGet$MaxTemp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MaxTempIndex, rowIndex, realmGet$MaxTemp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.MaxTempIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tererai.weatherapp.Model.FavoritesData.class);
        long tableNativePtr = table.getNativePtr();
        FavoritesDataColumnInfo columnInfo = (FavoritesDataColumnInfo) realm.getSchema().getColumnInfo(com.tererai.weatherapp.Model.FavoritesData.class);
        long pkColumnIndex = columnInfo.IDIndex;
        com.tererai.weatherapp.Model.FavoritesData object = null;
        while (objects.hasNext()) {
            object = (com.tererai.weatherapp.Model.FavoritesData) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$ID();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$City = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$City();
            if (realmGet$City != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CityIndex, rowIndex, realmGet$City, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.CityIndex, rowIndex, false);
            }
            String realmGet$CurrentCondition = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$CurrentCondition();
            if (realmGet$CurrentCondition != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CurrentConditionIndex, rowIndex, realmGet$CurrentCondition, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.CurrentConditionIndex, rowIndex, false);
            }
            String realmGet$MinTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$MinTemp();
            if (realmGet$MinTemp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MinTempIndex, rowIndex, realmGet$MinTemp, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.MinTempIndex, rowIndex, false);
            }
            String realmGet$CurrentTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$CurrentTemp();
            if (realmGet$CurrentTemp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CurrentTempIndex, rowIndex, realmGet$CurrentTemp, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.CurrentTempIndex, rowIndex, false);
            }
            String realmGet$MaxTemp = ((com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) object).realmGet$MaxTemp();
            if (realmGet$MaxTemp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MaxTempIndex, rowIndex, realmGet$MaxTemp, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.MaxTempIndex, rowIndex, false);
            }
        }
    }

    public static com.tererai.weatherapp.Model.FavoritesData createDetachedCopy(com.tererai.weatherapp.Model.FavoritesData realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.tererai.weatherapp.Model.FavoritesData unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.tererai.weatherapp.Model.FavoritesData();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.tererai.weatherapp.Model.FavoritesData) cachedObject.object;
            }
            unmanagedObject = (com.tererai.weatherapp.Model.FavoritesData) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface unmanagedCopy = (com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) unmanagedObject;
        com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface realmSource = (com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$ID(realmSource.realmGet$ID());
        unmanagedCopy.realmSet$City(realmSource.realmGet$City());
        unmanagedCopy.realmSet$CurrentCondition(realmSource.realmGet$CurrentCondition());
        unmanagedCopy.realmSet$MinTemp(realmSource.realmGet$MinTemp());
        unmanagedCopy.realmSet$CurrentTemp(realmSource.realmGet$CurrentTemp());
        unmanagedCopy.realmSet$MaxTemp(realmSource.realmGet$MaxTemp());

        return unmanagedObject;
    }

    static com.tererai.weatherapp.Model.FavoritesData update(Realm realm, FavoritesDataColumnInfo columnInfo, com.tererai.weatherapp.Model.FavoritesData realmObject, com.tererai.weatherapp.Model.FavoritesData newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface realmObjectTarget = (com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) realmObject;
        com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface realmObjectSource = (com_tererai_weatherapp_Model_FavoritesDataRealmProxyInterface) newObject;
        Table table = realm.getTable(com.tererai.weatherapp.Model.FavoritesData.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.IDIndex, realmObjectSource.realmGet$ID());
        builder.addString(columnInfo.CityIndex, realmObjectSource.realmGet$City());
        builder.addString(columnInfo.CurrentConditionIndex, realmObjectSource.realmGet$CurrentCondition());
        builder.addString(columnInfo.MinTempIndex, realmObjectSource.realmGet$MinTemp());
        builder.addString(columnInfo.CurrentTempIndex, realmObjectSource.realmGet$CurrentTemp());
        builder.addString(columnInfo.MaxTempIndex, realmObjectSource.realmGet$MaxTemp());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("FavoritesData = proxy[");
        stringBuilder.append("{ID:");
        stringBuilder.append(realmGet$ID() != null ? realmGet$ID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{City:");
        stringBuilder.append(realmGet$City() != null ? realmGet$City() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CurrentCondition:");
        stringBuilder.append(realmGet$CurrentCondition() != null ? realmGet$CurrentCondition() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{MinTemp:");
        stringBuilder.append(realmGet$MinTemp() != null ? realmGet$MinTemp() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CurrentTemp:");
        stringBuilder.append(realmGet$CurrentTemp() != null ? realmGet$CurrentTemp() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{MaxTemp:");
        stringBuilder.append(realmGet$MaxTemp() != null ? realmGet$MaxTemp() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_tererai_weatherapp_Model_FavoritesDataRealmProxy aFavoritesData = (com_tererai_weatherapp_Model_FavoritesDataRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFavoritesData.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFavoritesData.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFavoritesData.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
