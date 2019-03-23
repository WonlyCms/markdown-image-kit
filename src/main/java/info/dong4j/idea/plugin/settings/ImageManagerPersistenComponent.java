/*
 * MIT License
 *
 * Copyright (c) 2019 dong4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package info.dong4j.idea.plugin.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;

import org.jetbrains.annotations.NotNull;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 科大讯飞股份有限公司-四川分公司</p>
 * <p>Description: 配置持久化 </p>
 *
 * @author dong4j
 * @date 2019 -03-13 11:56
 * @email sjdong3 @iflytek.com
 */
@Slf4j
@State(name = "ImageManagerSetting", storages = @Storage(value = Storage.NOT_ROAMABLE_FILE, file = "$APP_CONFIG$/image.manager.configs.xml"))
public class ImageManagerPersistenComponent implements PersistentStateComponent<ImageManagerState> {

    /**
     * Get the instance of this service.
     *
     * @return the unique {@link ImageManagerPersistenComponent} instance.
     */
    public static ImageManagerPersistenComponent getInstance() {
        return ServiceManager.getService(ImageManagerPersistenComponent.class);
    }

    private ImageManagerState myState = new ImageManagerState();

    @Override
    public void loadState(@NotNull ImageManagerState state) {
        this.myState = state;
    }

    @NotNull
    @Override
    public ImageManagerState getState() {
        return this.myState;
    }
}