package info.dong4j.idea.plugin.sdk.qcloud.cos.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteObjectsResult implements Serializable {
    private final List<DeletedObject> deletedObjects =
            new ArrayList<DeletedObject>();

    public DeleteObjectsResult(List<DeletedObject> deletedObjects) {
        this.deletedObjects.addAll(deletedObjects);
    }

    /**
     * Returns the list of successfully deleted objects from this request. If
     * {@link DeleteObjectsRequest#getQuiet()} is true, only error responses will be returned from
     * cos, so this list will be empty.
     */
    public List<DeletedObject> getDeletedObjects() {
        return deletedObjects;
    }

    /**
     * A successfully deleted object.
     */
    static public class DeletedObject implements Serializable {

        private String key;
        private String versionId;
        private boolean deleteMarker;
        private String deleteMarkerVersionId;

        /**
         * Returns the key that was successfully deleted.
         */
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        /**
         * Returns the version deleted, or null for unversioned objects.
         */
        public String getVersionId() {
            return versionId;
        }

        public void setVersionId(String versionId) {
            this.versionId = versionId;
        }

        /**
         * Returns whether the object deleted was a delete marker.
         */
        public boolean isDeleteMarker() {
            return deleteMarker;
        }

        public void setDeleteMarker(boolean deleteMarker) {
            this.deleteMarker = deleteMarker;
        }

        /**
         * Returns the versionId for the delete marker that was created when doing a non-versioned
         * delete in a versioned bucket.
         */
        public String getDeleteMarkerVersionId() {
            return deleteMarkerVersionId;
        }

        public void setDeleteMarkerVersionId(String deleteMarkerVersionId) {
            this.deleteMarkerVersionId = deleteMarkerVersionId;
        }

    }
}
