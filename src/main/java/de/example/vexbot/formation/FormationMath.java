package de.example.vexbot.formation;

/**
 * Basic formation-position calculations.
 * Coordinates are expressed in Minecraft world units.
 */
public final class FormationMath {
    private FormationMath() {
    }

    /**
     * Calculates a slot in a square formation behind the player's facing direction.
     *
     * @param playerX player world X
     * @param playerZ player world Z
     * @param yawDegrees Minecraft yaw in degrees
     * @param rightOffset offset to the player's right
     * @param backOffset distance behind the player
     * @return a two-element array containing world X and Z
     */
    public static double[] squareSlotBehind(
            double playerX,
            double playerZ,
            float yawDegrees,
            double rightOffset,
            double backOffset
    ) {
        double yaw = Math.toRadians(yawDegrees);
        double forwardX = -Math.sin(yaw);
        double forwardZ = Math.cos(yaw);
        double rightX = forwardZ;
        double rightZ = -forwardX;

        double x = playerX - forwardX * backOffset + rightX * rightOffset;
        double z = playerZ - forwardZ * backOffset + rightZ * rightOffset;
        return new double[]{x, z};
    }

    /**
     * Moves a point forward by the given distance for a Minecraft yaw.
     */
    public static double[] advanceForward(double x, double z, float yawDegrees, double distance) {
        double yaw = Math.toRadians(yawDegrees);
        return new double[]{
                x - Math.sin(yaw) * distance,
                z + Math.cos(yaw) * distance
        };
    }
}
