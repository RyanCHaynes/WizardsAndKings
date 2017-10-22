package dev.IncanusGames.LineWarsRevamp.EntityManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Component.Component;


public final class EntityManager {
	private static int lowestUnassignedEntityID=1;
	public  List<Integer> Entities; //List of entities 
	private HashMap<Integer, LinkedList<Component>> EntityComponentMap; //Which components are in which entities
	public  HashMap<Class<?>, HashMap<Integer, ? extends Component>> componentStores;  // Component Type matched w/ HashMap of Entity to - instantiated component	
	

	public EntityManager(){
		Entities = new LinkedList<Integer>();
		componentStores = new HashMap<Class<?>, HashMap<Integer, ? extends Component>>();
		EntityComponentMap = new HashMap<Integer, LinkedList<Component>>();
	}
	
	public boolean hasComponentType(int entity, Class componentType) {
		for (Component Ca : EntityComponentMap.get(entity)) { //for every component type the entity has remove it from the ComponentStores
			if (Ca.getClass() == componentType) return true;
		}
		return false;
	}
	
	public <T extends Component> List<Integer> getAllEntititiesWithComponentType(Class<T> componentType){
		HashMap<Integer, ? extends Component> store = componentStores.get(componentType);
		if (store == null){
			return new LinkedList<Integer>();
		}
		else{
			List<Integer> result = new ArrayList<Integer>((java.util.Collection<Integer>)store.keySet());
			return result;}
	}
	public void removeEntity(int entityID) {
		//System.out.println(EntityComponentMap.get(entityID).size());
		for (Component Ca : EntityComponentMap.get(entityID)) { //for every component type the entity has remove it from the ComponentStores
			componentStores.get(Ca.getClass()).remove(entityID);
		}
		System.out.println("Removing: "+entityID);
		System.out.println("From: "+EntityComponentMap.keySet());
		System.out.println(EntityComponentMap.containsKey(entityID)); //removing entity from EntityComponentMap
		EntityComponentMap.get(entityID).clear();
		EntityComponentMap.remove(entityID);
	}
	
	public <T extends Component> T getComponent(int entity, Class<T> componentType){
		HashMap<Integer, ? extends Component> store = componentStores.get(componentType);
		if(store == null)
			throw new IllegalArgumentException("GET FAIL: there are no entities with a Component of class: "+ componentType);
		T result = componentType.cast(store.get(entity));
		if(result == null)
			throw new IllegalArgumentException("GET FAIL: " + entity + "does not possess Component of class \n missing "+ componentType);
		return result;
	}
	public <T extends Component> List<T> getAllComponentsOfType(Class<T> componentType){
		HashMap<Integer, ? extends Component> store = componentStores.get(componentType);
		if (store == null){
			return new LinkedList<T>();
		}
		else{
			List<T> result = new ArrayList<T>((java.util.Collection<T>)store.values());
			return result;
		}
	}
	public <T extends Component> void addComponent(int entity, T component){
		HashMap<Integer, ? extends Component> store = componentStores.get(component.getClass());
		
		if(store == null){
			store = new HashMap<Integer, T>();
			componentStores.put(component.getClass(), store);
		}
		((HashMap<Integer, T>)store).put(entity, component);
		EntityComponentMap.get(entity).addLast(component);
	}
	
	public void changeComponent(int entity, Component componentA, Component componentR){
		this.componentStores.get(componentA.getClass()).values();
		System.out.println("Changing component" + componentA.getClass());
	}
	
	public int createEntity(){
		int newID = generateNewEntityID();
		if(newID < 1){
			return 0;
		}
		else {
			Entities.add(newID);
			EntityComponentMap.put(newID, new LinkedList<>());
			return newID;
		}
	}
	private int generateNewEntityID(){
		synchronized(this) {
			if(lowestUnassignedEntityID < Integer.MAX_VALUE){
				return lowestUnassignedEntityID++;
			}
			else{
				for(int i =1; i<Integer.MAX_VALUE; i++){
					if(!Entities.contains(i))
						return i;		
				}
				throw new Error("ERROR: no available Entity IDs; too many entities!");
			}
		}
	}
	
}
