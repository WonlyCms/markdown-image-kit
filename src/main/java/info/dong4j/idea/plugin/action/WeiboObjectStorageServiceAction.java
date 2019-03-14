package info.dong4j.idea.plugin.action;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.io.*;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 上传到微博 OSS 事件</p>
 *
 * @author dong4j
 * @email sjdong3@iflytek.com
 * @since 2019-03-14 16:39
 */
public final class WeiboObjectStorageServiceAction extends AbstractObjectStorageService {
    @Contract(pure = true)
    @Override
    boolean isPassedTest() {
        // weibo 图床不需要测试
        return true;
    }

    @Nullable
    @Contract(pure = true)
    @Override
    String upload(File file) {
        return null;
    }
}
