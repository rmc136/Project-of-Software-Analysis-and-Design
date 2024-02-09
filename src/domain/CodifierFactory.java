package domain;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;

public enum CodifierFactory {
    INSTANCE;

    private Map<String, ICodifierStrategy> codifiers;
    private CodifierFactory() {
        codifiers = new HashMap<>();
        loadCodifiers();
    }
    
    public static CodifierFactory getInstance() {
        return INSTANCE;
    }

    private void loadCodifiers() {
        String separator = System.getProperty("file.separator");
        File codifiersFolder = new File(System.getProperty("user.dir") + separator + "bin" +
                separator + "domain" + separator + "codifiers");
        File[] classes = codifiersFolder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        });
        codifiers.put("Dummy", new DummyCodifier());
        for (File className : classes) {
            try {
                String s = className.getName();
                Class<?> codifierClass =
                        Class.forName("domain.codifiers." + s.substring(0, s.lastIndexOf('.')));
                if (codifierClass.getGenericSuperclass() == ICodifierStrategy.class &&
                        !s.equals("Dummy.class")) {
                    ICodifierStrategy codifier =
                            (ICodifierStrategy) codifierClass.getDeclaredConstructor().newInstance();
                    codifiers.put(codifier.getName(), codifier);
                }
            } catch (Exception e) {
                // Do nothing! Just ignore the class
            }
        }
    }

    public ICodifierStrategy getCodifier(String name) {
        try {
            return codifiers.get(name);
        } catch (Exception e) {
            return codifiers.get("Dummy");
        }
    }

    public Iterable<String> codifierList() {
        return codifiers.keySet();
    }
    
}