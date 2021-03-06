package info.dong4j.idea.plugin.sdk.qcloud.cos.internal.crypto;

import java.io.*;
import java.security.KeyPair;

import javax.crypto.SecretKey;

/**
 * KMS specific encryption materials.
 * <p>
 * The KEK has no relevance on the client-side, as KMS only requires the CMK
 * id to be used to uniquely identify the KEK on the server side.
 */
public class KMSEncryptionMaterials extends EncryptionMaterials implements Serializable {
    /**
     * Name of the material description to be persisted in COS for the KMS's
     * customer master key id.
     */
    public static final String CUSTOMER_MASTER_KEY_ID = "kms_cmk_id";
    /**
     * @param defaultCustomerMasterKeyId
     *            KMS's customer master key id; must not be null
     */
    public KMSEncryptionMaterials(String defaultCustomerMasterKeyId) {
        super(null, null);
        if (defaultCustomerMasterKeyId == null
                || defaultCustomerMasterKeyId.length() == 0)
            throw new IllegalArgumentException(
                    "The default customer master key id must be specified");
        addDescription(CUSTOMER_MASTER_KEY_ID, defaultCustomerMasterKeyId);
    }

    /**
     * Always throws <code>UnsupportedOperationException</code>.
     */
    @Override
    public final KeyPair getKeyPair() {
        throw new UnsupportedOperationException();
    }

    /**
     * Always throws <code>UnsupportedOperationException</code>.
     */
    @Override
    public final SecretKey getSymmetricKey() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     *
     * Always returns true.
     *
     * @return true
     */
    @Override
    public final boolean isKMSEnabled() {
        return true;
    }

    /**
     * Returns the default KMS's Customer Master Key ID; or null if there
     * isn't one.
     */
    @Override
    public String getCustomerMasterKeyId() {
        return getDescription(CUSTOMER_MASTER_KEY_ID);
    }

    @Override
    public String toString() {
        return String.valueOf(getMaterialsDescription());
    }
}