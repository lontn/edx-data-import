# edx-data-import
處理EdX資料來源

## 主要變更摘要

### Spring Framework 升級
- 從 **5.0.2.RELEASE** 升級到 **6.2.3**。
- 此升級修復了多個嚴重漏洞，並且專案已遷移使用 **Jakarta EE** (`javax.*` -> `jakarta.*`)。

### 安全性修復與依賴庫更新
- **Log4j2**：從 2.17.0 升級到 2.24.3，修復了知名的 Log4shell 後續相關漏洞。
- **Jackson** (JSON處理)：更新至 2.15.2，修復了反序列化漏洞。
- **Apache POI** (Excel處理)：大幅升級至 5.2.5 (原為 3.9)，提升對 Office 檔案的相容性與安全性。
- **MySQL Connector**：升級至 8.3.0。
- **Commons IO**：升級至 2.14.0。
- **Commons Lang3**：升級至 3.17.0。

### Java 版本提升
- 由於新版 Spring 與其他套件的需求，專案的編譯目標已從 **Java 1.8** 提升至 **Java 17**。

### 清理過時套件
- 移除了不再使用或過舊的依賴項，例如舊版的 `commons-configuration`。
