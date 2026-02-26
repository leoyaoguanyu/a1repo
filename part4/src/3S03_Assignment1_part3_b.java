import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubAgent implements CatanAgent {

    private int playerId;

    @Override
    public void init(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public Move chooseInitialSettlement(GameState state) {
        return state.getLegalSettlements(playerId).get(0);
    }

    @Override
    public Move chooseInitialRoad(GameState state) {
        return state.getLegalRoads(playerId).get(0);
    }

    @Override
    public Move chooseMove(GameState state) {
        return state.getLegalMoves(playerId).get(0);
    }

    @Override
    public Map<ResourceType, Integer> chooseDiscard(GameState state, int discardCount) {
        return new HashMap<>();
    }

    @Override
    public ResourceType chooseResource(GameState state) {
        return ResourceType.BRICK;
    }

    @Override
    public int chooseRobberTarget(GameState state, List<Integer> possibleTargets) {
        return possibleTargets.get(0);
    }

    @Override
    public DevelopmentCard chooseDevelopmentCard(GameState state) {
        return DevelopmentCard.KNIGHT;
    }
}
