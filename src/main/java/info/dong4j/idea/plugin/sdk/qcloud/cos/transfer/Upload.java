package info.dong4j.idea.plugin.sdk.qcloud.cos.transfer;

import info.dong4j.idea.plugin.sdk.qcloud.cos.exception.CosClientException;
import info.dong4j.idea.plugin.sdk.qcloud.cos.exception.CosServiceException;
import info.dong4j.idea.plugin.sdk.qcloud.cos.exception.PauseException;
import info.dong4j.idea.plugin.sdk.qcloud.cos.model.UploadResult;

/**
 * Represents an asynchronous upload to Qcloud COS.
 * <p>
 * See {@link TransferManager} for more information about creating transfers.
 * </p>
 *
 * @see TransferManager#upload(String, String, java.io.File)
 * @see TransferManager#upload(info.dong4j.idea.plugin.sdk.qcloud.cos.model.PutObjectRequest)
 */
public interface Upload extends Transfer {

    /**
     * Waits for this upload to complete and returns the result of this upload. This is a blocking
     * call. Be prepared to handle errors when calling this method. Any errors that occurred during
     * the asynchronous transfer will be re-thrown through this method.
     *
     * @return The result of this transfer.
     *
     * @throws CosClientException If any errors were encountered in the client while making the
     *         request or handling the response.
     * @throws CosServiceException If any errors occurred in Qcloud COS while processing the
     *         request.
     * @throws InterruptedException If this thread is interrupted while waiting for the upload to
     *         complete.
     */
    UploadResult waitForUploadResult()
            throws CosClientException, CosServiceException, InterruptedException;

    /**
     * Pause the current upload operation and returns the information that can be used to resume the
     * upload.
     *
     * Upload cannot be paused in the following cases.
     * <ul>
     * <li>The data source is an input stream.</li>
     * <li>Client side encryption is used.</li>
     * <li>Server Side Encryption with customer provided key is used.</li>
     * <li>Size of the file being uploaded is less than the
     * {@link TransferManagerConfiguration#getMultipartUploadThreshold()}.</li>
     * </ul>
     * In such cases, aborts the uploads and a <code>PauseFailure</code> exception is thrown
     *
     * @return An opaque token that holds some private state and can be used to resume a paused
     *         download operation.
     *
     * @throws PauseException If failed to pause the operation.
     */
    PersistableUpload pause() throws PauseException;

    /**
     * Tries to pause the current upload operation and returns the information that can be used to
     * resume the upload.
     *
     * Upload cannot be paused in the following cases.
     * <ul>
     * <li>The data source is an input stream.</li>
     * <li>Client side encryption is used.</li>
     * <li>Server Side Encryption with customer provided key is used.</li>
     * <li>Size of the file being uploaded is less than the
     * {@link TransferManagerConfiguration#getMultipartUploadThreshold()}.</li>
     * </ul>
     *
     * In such cases, aborts the uploads if forceCancelTransfers is set else No action is taken.
     *
     * @param forceCancelTransfers a boolean to forcefully abort the existing uploads if pause
     *        cannot be done.
     *
     * @return a result of pause operation.
     */
    PauseResult<PersistableUpload> tryPause(boolean forceCancelTransfers);

    /**
     * Abort the current upload operation.
     */
    void abort();

    /**
     * if multipart upload failed, whether we can upload again. if true, you can call
     * getResumeableMultipartUploadId to get upload info. then can resume to upload again..
     */
    boolean isResumeableMultipartUploadAfterFailed();

    /**
     * if isResumeableMultipartUploadAfterFailed is true, we can call getResumeableMultipartUploadId
     * to get upload info. then can resume to upload again..
     *
     * @return the PersistableUpload info if you can upload again, otherwise return null;
     */
    PersistableUpload getResumeableMultipartUploadId();

}
