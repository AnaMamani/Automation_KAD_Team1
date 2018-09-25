package com.jalasoft.sfdc.constants;

import java.util.HashMap;

/**
 * Created by Silvia Valencia on 7/12/2018.
 */
public class SFDCEnums {

    public enum Skin {
        CLASSIC("classic"),
        LIGHT("light");

        private String skinName;

        private Skin(String skinName) {
            this.skinName = skinName;
        }

        public String toSkinName() {
            return skinName;
        }

        private static final HashMap<String, Skin> BY_SKIN_MAP = new HashMap<>();

        static {
            for (Skin skin : Skin.values()) {
                BY_SKIN_MAP.put(skin.toSkinName(), skin);
            }
        }

        public static Skin getSkinEnumBySkinName(String skinName) {
            return BY_SKIN_MAP.get(skinName.toLowerCase());
        }
    }

    /**
     * User type defined in the automation framework for users with specific permissions that can be editable or not.
     */
    public enum UserType {

        ADMIN_USER("admin user"),
        ADMIN_LOCAL("local user"),
        ADMIN_OTHER("other role user");

        private String userType;

        /**
         * Sets the current User Type.
         *
         * @param userType - User type data.
         */
        UserType(final String userType) {
            this.userType = userType;
        }

        /**
         * Return the current userType.
         *
         * @return userType data.
         */
        public String toString() {
            return userType;
        }

        private static final HashMap<String, UserType> BY_USER_TYPE_MAP = new HashMap<>();

        static {
            for (UserType userType : UserType.values()) {
                BY_USER_TYPE_MAP.put(userType.toString(), userType);
            }
        }

        /**
         * Gets the UserType by userType.
         *
         * @param userType the user type.
         * @return the UserType.
         */
        public static UserType getUserType(final String userType) {
            return BY_USER_TYPE_MAP.get(userType);
        }
    }
}
