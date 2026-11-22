package de.example.vexbot.formation;

/**
 * Small decision helper. The calling mod must provide the world/collision checks.
 */
public final class JumpDecision {
    private JumpDecision() {
    }

    /**
     * Returns true when the path is blocked at foot level but clear above it,
     * and the obstacle is no higher than one block.
     *
     * These booleans must be calculated by the game integration code.
     */
    public static boolean shouldJumpOneBlock(
            boolean blockedAtFeet,
            boolean clearAboveObstacle,
            boolean hasGroundBelow,
            boolean canJump
    ) {
        return blockedAtFeet && clearAboveObstacle && hasGroundBelow && canJump;
    }
}
